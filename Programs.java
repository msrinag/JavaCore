import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Programs {


    public static int kthsmall(ArrayList<Integer> list, int k) 
    {
        if (k <= 0 || k > list.size()) 
        {
            throw new IllegalArgumentException("Invalid value of k");
        }

        Collections.sort(list); // Sort 
        return list.get(k - 1); // Return kth element
    }

    public static int maxele(ArrayList<Integer> list)
    {
     return Collections.max(list); // alternate we can sort and retuen last ele also

    }

    public static ArrayList<Integer> removedup(ArrayList<Integer> list)
    {//better methods are there also consider changing inplace else we can also use hashset and pass each item and get 
        for (int i = 0; i < list.size(); i++) 
        {
            for (int j = i + 1; j < list.size(); j++) 
            {
                if (list.get(i).equals(list.get(j))) 
                {
                    list.remove(j);
                    j--; 
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> intersect(ArrayList<Integer> list,ArrayList<Integer> list2)
    {// list may contian dup values so making hashset then chekcing and adding unadded values 
        HashSet<Integer> set1 = new HashSet<>(list);
        ArrayList<Integer> intersection = new ArrayList<>();

        for (Integer num : list2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }

    public static void wordfreq()
    {
        String S="Hello Wrold! hello world hello world";

        //convert string to lowercase if allowed

        S=S.toLowerCase();
        String[] words = S.split("\\s+"); //regex matching entire space so that more then one space case will be skipped
        HashMap<String, Integer> wordcount = new HashMap<>(); 
        for(String w:words)
        {
            wordcount.put(w,wordcount.getOrDefault(w,0)+1);

        }
        for (String w : wordcount.keySet()) {
            System.out.println(w + ": " + wordcount.get(w));
        }
    }

    public static LinkedList<Integer> reverselist(LinkedList<Integer> list)
    {
        LinkedList<Integer> revlist = new LinkedList<>();
        
       
        for (Integer i : list) {
            revlist.addFirst(i);// alawys adding items on head part
        }
        return revlist;
    }

    public static Integer list2nd(List<Integer> list) 
    {
        if (list == null || list.size() < 2) {
            return null; 
        }

        Collections.sort(list);

        return list.get(list.size()-2);
    }

    public static boolean havecom(HashSet<Integer> set1, HashSet<Integer> set2) {
      
        HashSet<Integer> tempSet = new HashSet<>(set1); 
        tempSet.retainAll(set2); 
        return !tempSet.isEmpty();
    }

    public static void getcharcountwithmap(String input) {
       
        Map<Character, Integer> charCountMap = new HashMap<>();

        
        for (char c : input.toCharArray()) {
            
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Print the character counts
        System.out.println("Character frequencies:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 7, 10, 4, 3, 20, 15, 20 );
        
        int k = 3;
        System.out.println("Kth Smallest: " + kthsmall(list, k)); 

        System.out.println("max ele: " + maxele(list)); 

        System.out.println("before  " + list); 

        System.out.println("after  " + removedup(list)); 


        ArrayList<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 6, 8, 41, 3, 20, 15 );
        System.out.println("list 1:"+ list); 
        System.out.println("list 2:"+ list2); 
        System.out.println("intresection of both  " + intersect(list,list2)); 

        Collections.addAll(list,20,20);

        System.out.println("before:"+ list); 
        System.out.println("distict of list: "+list.stream()
                                                .distinct()  // Removes duplicates i belive this was the change i.e filter was added
                                                .collect(Collectors.toList()));


       System.out.println("Word frequencies:");
       wordfreq(); 

       LinkedList<Integer> ll = new LinkedList<>();
       Collections.addAll(ll, 6, 8, 41, 3, 20, 15 );

       System.out.println("reverse list: " + reverselist(ll)); 

        List<Integer> listnew = new ArrayList<>();
        Collections.addAll(listnew, 7, 10, 4, 3, 20, 15 );
        
        
        System.out.println("2nd larget Smallest: " + list2nd(listnew)); 

        HashSet<Integer> set1 = new HashSet<>();
        Collections.addAll(set1,1,2,3,4,5);
        
        HashSet<Integer> set2 = new HashSet<>();
        Collections.addAll(set2,6,7,8);
        
        System.out.println("DO SET have common elementflag " + havecom(set1,set2)); 

        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("bmw", 30000);
        cars.put("benz", 40000);
        cars.put("gmc", 25000);

        TreeMap<String, Integer> carsmap = new TreeMap<>(cars);//alredy sorted by value since its tree if need for value we need to use custom comparator.

       System.out.println("alredy sorted by key " + carsmap);

       System.out.println("get char count of word");
       getcharcountwithmap("jsfbksjbfsdasdadsadadsda");




    }
}
