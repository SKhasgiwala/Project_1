package InfoRetrieval;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class partB {

    List<String> tokenize(String pathName) throws Exception
    {
        List<String> list = new ArrayList<>();
        try
        {
            File file = new File(pathName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            if (file.length() != 0)
            {

                while ((st = br.readLine()) != null)
                {
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
        }

        return list;
    }
    void printCommon(List l1, List l2) {

        l1.retainAll(l2);
        l1= (List) l1.stream().distinct().collect(Collectors.toList());
        System.out.println(l1.size());
        System.out.println("The common tokens are");
        Iterator<String> iterator=l1.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }



    public static void main(String args[]) throws FileNotFoundException {
        partB obj = new partB();

        try {
           List l1=obj.tokenize("/Users/salonikhasgiwala/Desktop/Winter 2018/Information Retrieval/temp1.txt");
           List l2=obj.tokenize("/Users/salonikhasgiwala/Desktop/Winter 2018/Information Retrieval/temp2.txt");
            obj.printCommon(l1,l2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
