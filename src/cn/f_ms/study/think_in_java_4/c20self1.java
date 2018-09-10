package cn.f_ms.study.think_in_java_4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class c20self1 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Json {
        String keyName();
    }

    public static StringBuffer toJson(Object object) {

        StringBuffer sb = new StringBuffer();

        // null
        if (object == null) {
            return sb.append("null");
        }

        // primitive
        if (object.getClass().isPrimitive()
                || object instanceof String) {
            return sb.append('"')
                    .append(object.toString())
                    .append('"');
        }

        // array
        if (object.getClass().isArray()) {
            object = Arrays.asList((Object[])object);
        }

        // list
        if (object instanceof List) {
            sb.append('[');

            Iterator iterator = ((List) object).iterator();
            while (iterator.hasNext()) {
                sb.append(toJson(iterator.next()));

                if (iterator.hasNext()) {
                    sb.append(',');
                }
            }
            return sb.append(']');
        }

        // object
        sb.append('{');

        boolean isExistField = false;
        for (Field field : object.getClass().getDeclaredFields()) {
            Json annotation = field.getAnnotation(Json.class);
            if (annotation != null) {
                if (!isExistField) {
                    isExistField = true;
                }

                sb.append('"')
                        .append(annotation.keyName())
                        .append("\":");

                Object value = null;
                try {
                    value = field.get(object);
                } catch (IllegalAccessException e) {
                    // ignore error
                }

                sb.append(toJson(value))
                        .append(',');
            }
        }

        // delete last ,
        if (isExistField) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.append('}');
    }

    static class Student {

        Student(String name, String gender, List<String> friendNames, List<Student> friends) {
            this.name = name;
            this.gender = gender;
            this.friendNames = friendNames;
            this.friends = friends;
        }

        @Json(keyName = "姓名")
        String name;
        @Json(keyName = "性别")
        String gender;
        @Json(keyName = "朋友们的姓名")
        List<String> friendNames;
        @Json(keyName = "朋友们的实例")
        List<Student> friends;
    }

    public static void main(String[] args) {

        System.out.println(
                toJson(Arrays.asList(
                        new Student(
                                "张三", "男",
                                Arrays.asList("李四", "二妞"),
                                Arrays.asList(new Student("张三的朋友", "女", null, null))
                        ),
                        new Student(
                                "李四", "女",
                                Arrays.asList("王五", "二妞"),
                                Arrays.asList(new Student("李四的朋友", "女", null, null))
                        ),
                        new Student(
                                "王五", "未知",
                                Arrays.asList("李四", "二妞"),
                                Arrays.asList(new Student("王五的朋友", "女", null, null))
                        ),
                        new Student(
                                "麻六", "女",
                                Arrays.asList("李四", "二妞"),
                                Arrays.asList(new Student("麻六的朋友", "女", null, null))
                        )
                ))
        );
    }

}
