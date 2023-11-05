
package com.mr.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 音频播放器
 * 
 * @author mingrisoft
 */
public class MusicPlayer implements Runnable {
    File soundFile; // 音乐文件
    Thread thread;// 父线程
    boolean circulate;// 是否循环播放

    /**
     * 构造器
     * 
     * @param filepath
     *                 �����ļ���������
     * @throws FileNotFoundException
     */
    public MusicPlayer(String filepath) throws FileNotFoundException {
        this(filepath, false);
    }

    /**
     * 构造器
     * 
     * @param filepath
     *                  �����ļ���������
     * @param circulate
     *                  �Ƿ�ѭ������
     * @throws FileNotFoundException
     */
    public MusicPlayer(String filepath, boolean circulate)
            throws FileNotFoundException {
        this.circulate = circulate;
        soundFile = new File(filepath);
        if (!soundFile.exists()) {// 如果文件不存在
            throw new FileNotFoundException(filepath + "文件不存在");
        }
    }

    /**
     * 开启线程
     */
    public void play() {
        thread = new Thread(this);// 创建线程对象
        thread.start();// 开启线程
    }

    /**
     * ͣ停止线程
     */
    public void stop() {
        thread.stop();
        // 强制关闭线程
    }

    /**
     * run方法
     */
    public void run() {
        byte[] auBuffer = new byte[1024 * 128];// 创建128kb缓冲区
        do {
            AudioInputStream audioInputStream = null; // 创建音频输入流对象
            SourceDataLine auline = null; // 混频器源数据行
            try {
                // 从音乐文件中获取音频输入流
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                AudioFormat format = audioInputStream.getFormat(); // 获取音频格式
                // 按照源数据行类型和指定音频格式创建数据行对象
                DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                        format);
                // 利用音频系统获得与指定Line.info对象中的描述匹配的行对象
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);// 按照指定格式打开源数据行
                auline.start();// 源数据行开启读写活动
                int byteCount = 0;// 记录音频输入流读出的字节数
                while (byteCount != -1) {// 如果音频输入流中读取的字节数不为-1
                    // 从音频数据流中读出128KB的数据
                    byteCount = audioInputStream.read(auBuffer, 0,
                            auBuffer.length);
                    if (byteCount >= 0) {// 如果读出有数据流
                        auline.write(auBuffer, 0, byteCount);// 将有效数据写入数据行中
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                auline.drain();// 清空数据行
                auline.close();// 关闭数据航
            }
        } while (circulate);// 根据循环标志判断是否循环播放
    }
}