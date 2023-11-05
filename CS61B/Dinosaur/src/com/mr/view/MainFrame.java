
package com.mr.view;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import com.mr.service.ScoreRecorder;
import com.mr.service.Sound;

/**
 * ������
 * 
 * @author mingrisoft
 *
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        restart();// ��ʼ
        setBounds(340, 150, 821, 260);// ���ú�������Ϳ���
        setTitle("奔跑吧！小恐龙！");// ����
        Sound.backgroud();// ���ű�������
        ScoreRecorder.init();// ��ȡ�÷ּ�¼
        addListener();// ���Ӽ���
        setDefaultCloseOperation(EXIT_ON_CLOSE);// �رմ�����ֹͣ����
    }

    /**
     * ���¿�ʼ
     */
    public void restart() {
        Container c = getContentPane();// ��ȡ����������
        c.removeAll();// ɾ���������������
        GamePanel panel = new GamePanel();// �����µ���Ϸ���
        c.add(panel);
        addKeyListener(panel);// ���Ӽ����¼�
        c.validate();// ����������֤�������
    }

    /**
     * ���Ӽ���
     */
    private void addListener() {
        addWindowListener(new WindowAdapter() {// ���Ӵ������
            public void windowClosing(WindowEvent e) {// ����ر�ǰ
                ScoreRecorder.saveScore();// ����ȷ�
            }
        });
    }
}
