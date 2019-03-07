//StringBuffer thread safe, synchronized
//StringBuilder thread unsafe, unsynchronized

// split: limit > 0, apply n - 1
//        limit < 0, apply as many as possible
//        limit == 0, apply as many as possible, trim empty
public class Codec {

  public String encode(List<String> strs) {
    StringBuffer out = new StringBuffer();
    for (String s : strs)
        out.append(s.replace("a", "aa")).append(" a ");
    return out.toString();
  }

  public List<String> decode(String s) {
    List strs = new ArrayList();
    String[] array = s.split(" a ", -1);
    for (int i=0; i<array.length-1; ++i)
        strs.add(array[i].replace("aa", "a"));
    return strs;
  }
}

public class Codec {

  public String encode(List<String> strs) {
      return strs.stream()
                 .map(s -> s.replace("#", "##") + " # ")
                 .collect(Collectors.joining());
  }
  
  public List<String> decode(String s) {
      List strs = Stream.of(s.split(" # ", -1))
                        .map(t -> t.replace("##", "#"))
                        .collect(Collectors.toList());
      strs.remove(strs.size() - 1);
      return strs;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
