package lambdasinaction.chap3;

import java.util.function.Function;

class Letter {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        //A second pipeline might be only adding a header and footer without checking for spelling:
        Function<String, String> addHeader2 = Letter::addHeader;
        Function<String, String> transformationPipeline2
                = addHeader.andThen(Letter::addFooter);
    }

    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
