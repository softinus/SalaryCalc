package com.raimsoft.salarycalc;

import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import bayaba.engine.lib.GameInfo;
import bayaba.engine.lib.GameObject;
import bayaba.engine.lib.Sprite;
import bayaba.engine.lib.UITool;

public class GameMain
{
	public GL10 mGL = null; // OpenGL 객체
	public Context MainContext;
	public Random MyRand = new Random();	
	public GameInfo gInfo; // 게임 환경 설정용 클래스 : MainActivity에 선언된 것을 전달 받는다.
	public float TouchX, TouchY;
	public int CurLayer = 0;
    
	private Sprite SPR_bg;
	private GameObject OBJ_bg;
	//private UITool ui;

	public GameMain( Context context, GameInfo info )
	{
		MainContext = context;
		gInfo = info;
	}

	public void LoadGameData()
	{
		SPR_bg= new Sprite();
		SPR_bg.LoadSprite(mGL, MainContext, "salarycalc_main1.spr");
		
		OBJ_bg= new GameObject();
		OBJ_bg.SetObject(SPR_bg, 0, 0, 0, 0, 0, 0);
	}
	
	public void PushButton( boolean flag )
	{
		
	}
	
	public void DoGame()
	{
		this.Render();
	}
	
	protected void Render()
	{
		OBJ_bg.DrawSprite(gInfo);
	}
}
