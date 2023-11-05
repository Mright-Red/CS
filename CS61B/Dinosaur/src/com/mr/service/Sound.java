
package com.mr.service;

import java.io.FileNotFoundException;

/**
 * ��Ч��
 * 
 * @author mingrisoft
 *
 */
public class Sound {
    static final String DIR = "music/";// 音乐文件夹
    static final String BACKGROUD = "background.wav";// 背景音乐
    static final String JUMP = "jump.wav";// 跳跃音效
    static final String HIT = "hit.wav";// 撞击音效

    /**
     * 播放跳跃音效
     */
    static public void jump() {
        play(DIR + JUMP, false);// 一次
    }

    /**
     * 播放撞击音效
     */
    static public void hit() {
        play(DIR + HIT, false);// 一次
    }

    /**
     * 播放背景音乐
     */
    static public void backgroud() {
        play(DIR + BACKGROUD, true);// 循环
    }

    /**
     * 播放声音
     * 
     * @param file
     *                  音乐文件完整名称
     * @param circulate
     *                  是否循环
     */
    private static void play(String file, boolean circulate) {
        try {
            // 创建播放器
            MusicPlayer player = new MusicPlayer(file, circulate);
            player.play();// 播放器开始播放
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
