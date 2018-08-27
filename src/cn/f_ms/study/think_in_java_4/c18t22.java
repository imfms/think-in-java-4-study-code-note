package cn.f_ms.study.think_in_java_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class c18t22 {

   public static void main(String[] args) throws IOException {

      List<String> java = process("echo", "a");

      for (String s : java) {
         System.out.println(s);
      }

   }

   public static List<String> process(String... args) throws IOException {

      Process process = new ProcessBuilder(args).start();

      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      List<String> results = new ArrayList<>();

      String result;
      while ((result = reader.readLine()) != null) {
         results.add(result);
      }

      return results;
   }

}
