package com.alphabethub.exam.iqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Solution s = new Solution();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10000));
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        List<Line> lines = Arrays.stream(next.split(",")).map(str -> new StringLine(str))
                .collect(Collectors.toList());
        List<Line> result = s.translateAll(lines, "", threadPoolExecutor);
        String resultString = result.stream().map(l -> l.toString()).collect(Collectors.joining(","));
        System.out.println(resultString);
        reader.close();
        threadPoolExecutor.shutdown();
    }

    public interface Line {
        /**
         * translate the line to the specific language
         *
         * @param language - the language to translate
         * @return the line of translated by the {@code language}
         */
        Line translate(String language);
    }

    public static class Solution {
        /**
         * translate the all lines to the specific language
         *
         * @param lines    the text lines of episode
         * @param language the language to translate
         * @return the lines of translated by the {@code language}
         */
        public List<Line> translateAll(List<Line> lines, String language, ThreadPoolExecutor executor) throws InterruptedException, ExecutionException {
            List<Future<Line>> futureList = new ArrayList<>();
            List<Line> result = new ArrayList<>();
            for (Line line : lines) {
                futureList.add(executor.submit(new Job<Line>(line, language)));
            }

            for (Future<Line> future : futureList) {
                result.add(future.get());
            }
            return result;
        }
    }

    public static class Job<V> implements Callable {
        private Line line;
        private String language;

        public Job(Line line, String language) {
            this.line = line;
            this.language = language;
        }

        @Override
        public Line call() {
            return line.translate(language);
        }
    }

    /**
     * translate the string line to upper case
     */
    public static class StringLine implements Line {
        private String text;

        public StringLine(String text) {
            this.text = text;
        }

        @Override
        public Line translate(String language) {
            return new StringLine(text.toUpperCase());
        }


        @Override
        public String toString() {
            return text;
        }
    }
}
