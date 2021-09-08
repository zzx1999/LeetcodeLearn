package Stringoperation;

public class replaceSpaceoff05 {
    public String replaceSpace(String s) {
        String s1 = s.replaceAll(" ","%20");
        return s1;
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        replaceSpaceoff05 rs = new replaceSpaceoff05();
        rs.replaceSpace(s);
    }
}
