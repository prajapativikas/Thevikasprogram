import javax.swing.*;  
public class JtabbbedExample {  
JFrame f;  
JtabbbedExample(){  
    f=new JFrame();  
    JTextArea ta=new JTextArea(200,200);  
    JPanel p1=new JPanel();  
    p1.add(ta);  
    JPanel p2=new JPanel();  
    JPanel p3=new JPanel();  
    JPanel p4=new JPanel(); 
    JTabbedPane tp=new JTabbedPane();  
    tp.setBounds(50,50,300,200);  
    tp.add("main",p1);  
    tp.add("visit",p2);  
    tp.add("help",p3); 
    tp.add("remark",p4); 
    f.add(tp);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new JtabbbedExample();  
}}  