public class AutocompleteSystem {

   class Node {
       String content;
       int times;

       Node(String content, int times) {
           this.content = content;
           this.times = times;
       }
   }

   class Trie {
       Trie[] trie;
       int times;

       Trie() {
           trie = new Trie[27];
           times = 0;
       }
   }

   Trie root;

   private void buildTrie(String sentence, int times) {
       Trie t = root;
       for (char c : sentence.toCharArray()) {
           if (c == ' ') {
               if (t.trie[26] == null) {
                   t.trie[26] = new Trie();
               }
               t = t.trie[26];
           } else {
               if (t.trie[c - 'a'] == null) {
                   t.trie[c - 'a'] = new Trie();
               }
               t = t.trie[c - 'a'];
           }
       }
       t.times += times;
   }

   public AutocompleteSystem(String[] sentences, int[] times) {
       this.root = new Trie();
       for (int i = 0; i < sentences.length; i++) {
           buildTrie(sentences[i], times[i]);
       }
   }

   String current = "";

   private void traverse(Trie t, String temp, List<Node> result) {
       if (t.times > 0) {
           result.add(new Node(temp, t.times));
       }
       for (char i = 'a'; i <= 'z'; i++) {
           if (t.trie[i - 'a'] != null) {
               traverse(t.trie[i - 'a'], temp + String.valueOf(i), result);
           }
       }
       if (t.trie[26] != null) {
           traverse(t.trie[26], temp + " ", result);
       }
   }

   private List<Node> lookUp() {
       Trie t = root;
       List<Node> result = new LinkedList<>();
       for (char c : current.toCharArray()) {
           if (c == ' ') {
               if (t.trie[26] == null) {
                   return result;
               }
               t = t.trie[26];
           } else {
               if (t.trie[c - 'a'] == null) {
                   return result;
               }
               t = t.trie[c - 'a'];
           }
       }
       traverse(t, current, result);
       return result;
   }

   public List<String> input(char c) {
       List<String> list = new LinkedList<>();
       if (c == '#') {
           buildTrie(current, 1);
           current = "";
       } else {
           current += String.valueOf(c);
           List<Node> result = lookUp();
           Collections.sort(result, (a, b) -> {
            if (a.times == b.times) {
              return a.content.compareTo(b.content);
            } else {
              return a.times - b.times;
            }
           });
           for (Node node : result) {
               list.add(node.content);
           }
       }
       return list;
   }
}


public class AutocompleteSystem {
    class Node {
        Node(String st, int t) {
            sentence = st;
            times = t;
        }
        String sentence;
        int times;
    }

    class Trie {
        int times;
        Trie[] branches = new Trie[27];
    }

    public int int_(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    public void insert(Trie t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null)
                t.branches[int_(s.charAt(i))] = new Trie();
            t = t.branches[int_(s.charAt(i))];
        }
        t.times += times;
    }

    public List < Node > lookup(Trie t, String s) {
        List < Node > list = new ArrayList < > ();
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null)
                return new ArrayList < Node > ();
            t = t.branches[int_(s.charAt(i))];
        }
        traverse(s, t, list);
        return list;
    }

    public void traverse(String s, Trie t, List < Node > list) {
        if (t.times > 0)
            list.add(new Node(s, t.times));
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null)
                traverse(s + i, t.branches[i - 'a'], list);
        }
        if (t.branches[26] != null)
            traverse(s + ' ', t.branches[26], list);
    }

    Trie root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    String cur_sent = "";

    public List < String > input(char c) {
        List < String > res = new ArrayList < > ();
        if (c == '#') {
            insert(root, cur_sent, 1);
            cur_sent = "";
        } else {
            cur_sent += c;
            List < Node > list = lookup(root, cur_sent);
            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).sentence);
        }
        return res;
    }
}
