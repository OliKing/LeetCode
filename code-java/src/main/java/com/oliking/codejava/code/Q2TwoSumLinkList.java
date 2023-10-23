package com.oliking.codejava.code;


import com.oliking.codejava.util.ListNode;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q2TwoSumLinkList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int k = 0;
        ListNode head = l1;
        ListNode p = l1;
        while (l1 != null && l2!= null){
            int d = (l1.val + l2.val + k)%10;
            k = (l1.val + l2.val + k)/10;
            l1.val = d;
            p = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode q = new ListNode();
        while(l1!= null){
            q = l1;
            if ((l1.val + k) < 10){
                l1.val +=1;
                k = 0;
                break;
            }
            int d = (l1.val + k)%10;
            k = (l1.val + k)/10;
            l1.val = d;
            l1 = l1.next;
        }
        if(l2!= null){
            q = l2;
            p.next = l2;
            while(l2!=null){
                if ((l2.val + k) < 10){
                    l2.val +=1;
                    k = 0;
                    break;
                }
                int d = (l2.val + k)%10;
                k = (l2.val + k)/10;
                l2.val = d;
                l2 = l2.next;
            }

        }
        if (k>0){
            q.next = new ListNode(k);
            p.next = new ListNode(k);
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        File files = new File("C:\\Users\\sxl\\Pictures\\apic2098.jpg");
        byte[] bytesArray = new byte[(int) files.length()];

        FileInputStream fis = new FileInputStream(files);
        fis.read(bytesArray); //read file into bytes[]
        fis.close();
        System.out.println(bytesArray.length/1024.0);

//        byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\sxl\\Pictures\\apic2098.jpg"));
//        System.out.println(bytes.length/1024.0);

        String tagePath = "C:\\Users\\sxl\\Pictures\\new.png";
        File file = new File(tagePath);
        if (!file.exists()) { file.createNewFile(); }
            // 把图片读入到内存中
//        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//        BufferedImage bufImg = ImageIO.read(in);
//        int width = bufImg.getWidth();
//        int height = bufImg.getHeight();
//        // 图处理
//        BufferedImage bufferedImage = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(), BufferedImage.TYPE_INT_RGB);
//        bufferedImage.createGraphics().drawImage(bufImg.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING), 0, 0, Color.WHITE, null);
//        FileOutputStream fileOutputStream = new FileOutputStream(tagePath);
//        // jpg 是图片类型,你可以动态传入
//        ImageIO.write(bufferedImage, "png", fileOutputStream);
//        fileOutputStream.close();

        FileImageOutputStream imageOutput = new FileImageOutputStream(file);//打开输入流
        imageOutput.write(bytesArray, 0, bytesArray.length);//将byte写入硬盘
        imageOutput.close();

//        byte[] bytes = Files.readAllBytes(Paths.get("D:\\new.png"));
//        System.out.println(bytes.length/1024.0);
//        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        double x = Math.sqrt(5.0/(bytes.length/1024.0));
////        Thumbnails.of(in).scale(x).toOutputStream(out);
//        bytes = out.toByteArray();
//        System.out.println(bytes.length/1024.0);
//        FileImageOutputStream imageOutput = new FileImageOutputStream(new File("C:\\Users\\Administrator\\Desktop\\new.png"));//打开输入流
//        imageOutput.write(bytes, 0, bytes.length);//将byte写入硬盘
//        imageOutput.close();
    }
}
