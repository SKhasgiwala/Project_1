package InfoRetrieval;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

//Eliminating all special characters
//Future: deal properly with '
public class partA {
    List<String> tokenize(String pathName)
    {
        List<String> list = new ArrayList<>();
        try
        {
            File file = new File(pathName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            //String s[]=new String[(int) file.length()];
            if (file.length() != 0)
            {

                while ((st = br.readLine()) != null)
                {   //StringTokenizer stringTokenizer=new StringTokenizer(st," ");
                    if (st != null && !st.equals(""))
                    {
                        st=st.toLowerCase().replaceAll("[^a-zA-Z0-9\\\\s+]"," ");
                    }
                    StringTokenizer stringTokenizer=new StringTokenizer(st," ");
                    while(stringTokenizer.hasMoreTokens())
                    {
                        list.add(stringTokenizer.nextToken());
                    }
                }

            }
            else
            {
                System.out.println("File is Empty");
                System.exit(0);
            }
            br.close();
        }

        catch (FileNotFoundException e1)
        {
            System.out.println("File does not exists");
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.computeWordFrequencies(list);
        return list;
    }


    Map<String,Integer> computeWordFrequencies(List list)
    {
        Map<String,Integer> hashMap=new HashMap<>();
        Iterator iterator=list.iterator();
        while(iterator.hasNext())
        {
            String string= (String) iterator.next();
            if(!hashMap.containsKey(string))
            {
                hashMap.put(string,1);
            }
            else
            {
                hashMap.put(string,hashMap.get(string)+1);
            }
        }
        this.printFreq(hashMap);
        return hashMap;
    }

    Map<String,Integer> printFreq(Map<String,Integer> map)
    {
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        String key;
        int value;
        for(Map.Entry<String,Integer> entry : list) {
            key = entry.getKey();
            value=entry.getValue();
            System.out.println(key+" : "+value);
        }
        return map;
    }

    public static void main(String args[])
    {
        partA obj=new partA();
        List<String> lst = new ArrayList<> ();
        obj.tokenize("/Users/salonikhasgiwala/Desktop/Winter 2018/Information Retrieval/temp.txt");
    }
}

