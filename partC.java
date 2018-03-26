package InfoRetrieval;

import java.io.*;
import java.util.*;


public class partC {


    Map<String, String> compute(BufferedReader bufferedReader) throws IOException {
        String line;
        Map<String, String> map=new HashMap<>();
        while((line=bufferedReader.readLine())!=null)
        {
            line=line.replaceAll("[^a-zA-Z0-9\\\\s+]"," ");
            String parts[]=line.split(" ", 2);
            if(parts.length>=2)
            {
                String key=parts[0];
                String value=parts[1];
                map.put(key,value);

            }
        }
        return map;

    }

    Map<String,String> union(Map map1,Map map2) throws IOException {

        Map<String,String> ret = new HashMap<>(map1);
        for(Object s:map2.keySet())
        {
            if(ret.containsKey(s))
            {
                int num1=Integer.parseInt((String) map1.get(s));
                int num2=Integer.parseInt((String) map2.get(s));
                int num3=num1+num2;
                ret.put((String) s,Integer.toString(num3));
            }
            else
            {
                ret.put((String)s, (String) map2.get(s));
            }
        }
        String key;
        String value;
        for(Map.Entry<String,String> map3:ret.entrySet())
        {
            key=map3.getKey();
            value=map3.getValue();
            System.out.println(key+", "+value);
        }
        return ret;

    }



    public static void main(String args[]) throws IOException {
        partC obj = new partC();
        Map<String,String > map1=new HashMap<>();
        Map<String,String > map2=new HashMap<>();

        File file1=new File("/Users/salonikhasgiwala/Desktop/Winter 2018/Information Retrieval/temp3.txt");
        BufferedReader bufferedReader1=new BufferedReader(new FileReader(file1));
        File file2=new File("/Users/salonikhasgiwala/Desktop/Winter 2018/Information Retrieval/temp4.txt");
        BufferedReader bufferedReader2=new BufferedReader(new FileReader(file2));
        if(file1.length()!=0&&file2.length()!=0) {
             map1 = obj.compute(bufferedReader1);
            map2 = obj.compute(bufferedReader2);
        }
        else
        {
            System.out.println("File is Empty");
            System.exit(0);
        }

        Map result = obj.union(map1, map2);


        FileWriter fstream=new FileWriter("/Users/salonikhasgiwala/Desktop/Winter 2018/Information Retrieval/write.txt");
        BufferedWriter out=new BufferedWriter(fstream);
        Iterator<Map.Entry<String,String>> it=result.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String,String> pairs=it.next();
            out.write(pairs.getKey()+", "+pairs.getValue());
            out.newLine();
        }
        System.out.println("Write done");
        out.close();

    }
}
