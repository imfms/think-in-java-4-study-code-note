package cn.f_ms.study.think_in_java_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class c13t17 {

    public static final String JAVA_STRING = "/*\n" +
            " * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.\n" +
            " * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.\n" +
            " */\n" +
            "package java.lang;\n" +
            "\n" +
            "import java.util.Iterator;\n" +
            "import java.util.Objects;\n" +
            "import java.util.Spliterator;\n" +
            "import java.util.Spliterators;\n" +
            "import java.util.function.Consumer;\n" +
            "\n" +
            "/**\n" +
            " * Implementing this interface allows an object to be the target of\n" +
            " * the \"for-each loop\" statement. See\n" +
            " * <strong>\n" +
            " * <a href=\"{@docRoot}/../technotes/guides/language/foreach.html\">For-each Loop</a>\n" +
            " * </strong>\n" +
            " *\n" +
            " * @param <T> the type of elements returned by the iterator\n" +
            " *\n" +
            " * @since 1.5\n" +
            " * @jls 14.14.2 The enhanced for statement\n" +
            " */\n" +
            "public interface Iterable<T> {\n" +
            "    /**\n" +
            "     * Returns an iterator over elements of type {@code T}.\n" +
            "     *\n" +
            "     * @return an Iterator.\n" +
            "     */\n" +
            "    Iterator<T> iterator();\n" +
            "\n" +
            "    /**\n" +
            "     * Performs the given action for each element of the {@code Iterable}\n" +
            "     * until all elements have been processed or the action throws an\n" +
            "     * exception.  Unless otherwise specified by the implementing class,\n" +
            "     * actions are performed in the order of iteration (if an iteration order\n" +
            "     * is specified).  Exceptions thrown by the action are relayed to the\n" +
            "     * caller.\n" +
            "     *\n" +
            "     * @implSpec\n" +
            "     * <p>The default implementation behaves as if:\n" +
            "     * <pre>{@code\n" +
            "     *     for (T t : this)\n" +
            "     *         action.accept(t);\n" +
            "     * }</pre>\n" +
            "     *\n" +
            "     * @param action The action to be performed for each element\n" +
            "     * @throws NullPointerException if the specified action is null\n" +
            "     * @since 1.8\n" +
            "     */\n" +
            "    default void forEach(Consumer<? super T> action) {\n" +
            "        Objects.requireNonNull(action);\n" +
            "        for (T t : this) {\n" +
            "            action.accept(t);\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * Creates a {@link Spliterator} over the elements described by this\n" +
            "     * {@code Iterable}.\n" +
            "     *\n" +
            "     * @implSpec\n" +
            "     * The default implementation creates an\n" +
            "     * <em><a href=\"Spliterator.html#binding\">early-binding</a></em>\n" +
            "     * spliterator from the iterable's {@code Iterator}.  The spliterator\n" +
            "     * inherits the <em>fail-fast</em> properties of the iterable's iterator.\n" +
            "     *\n" +
            "     * @implNote\n" +
            "     * The default implementation should usually be overridden.  The\n" +
            "     * spliterator returned by the default implementation has poor splitting\n" +
            "     * capabilities, is unsized, and does not report any spliterator\n" +
            "     * characteristics. Implementing classes can nearly always provide a\n" +
            "     * better implementation.\n" +
            "     *\n" +
            "     * @return a {@code Spliterator} over the elements described by this\n" +
            "     * {@code Iterable}.\n" +
            "     * @since 1.8\n" +
            "     */\n" +
            "    default Spliterator<T> spliterator() {\n" +
            "    // single line comment\n" +
            "        return Spliterators.spliteratorUnknownSize(iterator(), 0);// single line comment2\n" +
            "    }\n" +
            "}\n";

    public static void main(String[] args) {
        doIt(JAVA_STRING);
    }

    public static void doIt(String javaString) {

        Matcher matcher = Pattern.compile("(?sm)(/\\*+.*?\\*/)|(//.*?$)").matcher(javaString);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

}
