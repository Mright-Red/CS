
package com.mr.service;

import java.io.*;
import java.util.Arrays;

/**
 * 计分器类
 * 
 * @author mright
 *
 */
public class ScoreRecorder {
    private static final String SCOREFILE = "data/soure";// �÷ּ�¼�ļ�
    private static int scores[] = new int[3];// ��ǰ�÷����ǰ����

    /**
     * ������ʼ��
     */
    public static void init() {
        File f = new File(SCOREFILE);// ������¼�ļ�
        if (!f.exists()) {// ����ļ�������
            try {
                f.createNewFile();// �������ļ�
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;// ֹͣ����
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(f);// �ļ��ֽ�������
            isr = new InputStreamReader(fis);// �ֽ���ת�ַ���
            br = new BufferedReader(isr);// �����ַ���
            String value = br.readLine();// ��ȡһ��
            if (!(value == null || "".equals(value))) {// �����Ϊ��ֵ
                String vs[] = value.split(",");// �ָ��ַ���
                if (vs.length < 3) {// ����ָ���С��3
                    Arrays.fill(scores, 0);// �������0
                } else {
                    for (int i = 0; i < 3; i++) {
                        // ����¼�ļ��е�ֵ������ǰ��������
                        scores[i] = Integer.parseInt(vs[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {// ���ιر���
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * �������
     */
    public static void saveScore() {
        // ƴ�ӵ÷�����
        String value = scores[0] + "," + scores[1] + "," + scores[2];
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(SCOREFILE);// �ļ��ֽ������
            osw = new OutputStreamWriter(fos);// �ֽ���ת�ַ���
            bw = new BufferedWriter(osw);// �����ַ���
            bw.write(value);// д��ƴ�Ӻ���ַ���
            bw.flush();// �ַ���ˢ��
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {// ���ιر���
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ���ӷ�������������ӵķ��������а�����ߣ���Ὣ�·����������а�
     * 
     * @param score
     *              �·���
     */
    static public void addNewScore(int score) {
        // �ڵ÷����������ϴ���һ������Ϊ4����ʱ����
        int tmp[] = Arrays.copyOf(scores, 4);
        tmp[3] = score;// ���·�����ֵ�����ĸ�Ԫ��
        Arrays.sort(tmp);// ��ʱ���齵������
        scores = Arrays.copyOfRange(tmp, 1, 4);// ��������Ԫ�ظ�ֵ���÷�����
    }

    /**
     * ��ȡ����
     * 
     * @return
     */
    static public int[] getScores() {
        return scores;
    }

}
