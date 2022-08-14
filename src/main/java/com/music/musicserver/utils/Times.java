package com.music.musicserver.utils;

public class Times {
    public static void main(String[] args) {
        int []hou=new int[143];
        int []sec=new int[143];
        hou[0]=0;
        sec[0]=0;
        hou[1]=10;
        sec[1]=52;
        hou[2]=6;
        sec[2]=10;
        hou[3]=22;
        sec[3]=43;
        hou[4]=6;
        sec[4]=9;
        hou[5]=4;
        sec[5]=31;
        hou[6]=22;
        sec[6]=0;
        hou[7]=12;
        sec[7]=7;
        hou[8]=16;
        sec[8]=53;
        hou[9]=4;
        sec[9]=28;
        hou[10]=26;
        sec[10]=27;
        hou[11]=18;
        sec[11]=12;
        hou[12]=19;
        sec[12]=7;
        hou[13]=7;
        sec[13]=38;
        hou[14]=21;
        sec[14]=16;
        hou[15]=16;
        sec[15]=24;
        hou[16]=18;
        sec[16]=27;
        hou[17]=13;
        sec[17]=29;
        hou[18]=6;
        sec[18]=2;
        hou[19]=5;
        sec[19]=17;
        hou[20]=4;
        sec[20]=42;
        hou[21]=17;
        sec[21]=16;
        hou[22]=4;
        sec[22]=54;
        hou[23]=22;
        sec[23]=26;
        hou[24]=13;
        sec[24]=31;
        hou[25]=23;
        sec[25]=8;
        hou[26]=20;
        sec[26]=55;
        hou[27]=7;
        sec[27]=7;
        hou[28]=10;
        sec[28]=4;
        hou[29]=14;
        sec[29]=5;
        hou[30]=16;
        sec[30]=18;
        hou[31]=9;
        sec[31]=32;


        int housum=0;
        int secsum=0;
        for (int i = 0; i < 143; i++) {
            housum+=hou[i];
            secsum+=sec[i];
        }
        int time=housum+(secsum/60);
        int t=time/60;
        int t1=time%60;
        int s=secsum%60;
        System.out.println("已经学习 "+t+" 小时 "+t1+" 分钟 "+s+" 秒");
        int rest=0,resm=0,ress=0;
        int fint=32,finm=31,fins=37;
        if(fins<s){
            fins+=60;
            ress=fins-s;
            finm=finm-1;
        }else {
            ress=fins-s;
        }
        if(finm<t1){
            finm+=60;
            resm=finm-t1;
            fint-=1;
        }else {
            resm=finm-t1;
        }
        rest=fint-t;
        System.out.println("还剩下 "+rest+" 小时 "+resm+" 分种 "+ress+" 秒 ");

    }
}
