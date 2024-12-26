package com.liyuan.binx.balking;

import java.io.IOException;
import java.util.Scanner;

public class DocumentEditThread extends Thread {

    private final String documentPath;

    private final String documentName;

    private final Scanner scanner = new Scanner(System.in);

    private DocumentEditThread(String documentPath, String documentName) {
        super("DocumentEditThread");
        this.documentPath = documentPath;
        this.documentName = documentName;
    }

    public static DocumentEditThread create(String documentPath, String documentName) {
        DocumentEditThread documentEditThread = new DocumentEditThread(documentPath, documentName);
        return documentEditThread;
    }

    @Override
    public void run() {
        int times = 0;
        try {
            Document document = Document.create(documentPath, documentName);
            while (true) {
                // 获取键盘输入
                String text = scanner.next();

                if ("quit".equals(text)) {
                    document.close();
                    break;
                }

                // 将内容编辑到document中
                document.edit(text);
                if (times == 5) {
                    // 输入五次后，触发手动保存动作
                    document.save();
                    times = 0;
                }
                times++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
