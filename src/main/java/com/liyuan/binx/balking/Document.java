package com.liyuan.binx.balking;

import javax.print.Doc;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Document {

    // 如果文档发生变化，changed 会被设置成true
    private boolean changed = false;

    // 一次需要保存的内容，可以理解为缓存
    private List<String> content = new ArrayList<>();

    // 自动保存文档的缓存
    private static AutoSaveThread autoSaveThread;

    private final FileWriter fileWriter;

    // 构造函数需要传入文档的路径和名称
    private Document(String documentPath, String documentName) throws IOException {
        fileWriter = new FileWriter(new File(documentPath, documentName));
    }

    // 静态方法，用于创建文档，并且顺便启动自动保存线程
    public static Document create(String documentPath, String documentName) throws IOException {
        Document document = new Document(documentPath, documentName);
        autoSaveThread = new AutoSaveThread(document);
        autoSaveThread.start();
        return document;
    }

    // 相当于给缓存list中增加，并把标识位改为true
    public void edit(String content) {
        synchronized (this) {
            this.content.add(content);
            // 文档改变，changed 会变为true
            this.changed = true;
        }
    }

    //  先关闭自动保存线程，然后释放writer资源
    public void close() throws IOException {
        autoSaveThread.interrupt();
        fileWriter.close();
    }

    public void  save() throws IOException {
        synchronized (this) {
            // 如果已经保存过了，则balking,直接返回
             if (!changed) {
                 return;
             }
            System.out.println(Thread.currentThread() + " execute the save action");
             // 将内容写入文档中
            for (String cacheLine : content) {
                this.fileWriter.write(cacheLine);
                this.fileWriter.write("\r\n");
            }
            this.fileWriter.flush();
            // 将标识为改为false，标识此刻没有内容被编辑
            this.changed = false;
            this.content.clear();
        }
    }




}
