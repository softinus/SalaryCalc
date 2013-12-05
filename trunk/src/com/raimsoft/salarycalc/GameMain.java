package com.raimsoft.salarycalc;

import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import bayaba.engine.lib.ButtonType;
import bayaba.engine.lib.Font;
import bayaba.engine.lib.GameInfo;
import bayaba.engine.lib.GameObject;
import bayaba.engine.lib.Sprite;
import bayaba.engine.lib.UITool;

public class GameMain
{
	static class UIPage1
	{
		static class Group0
		{
			static final int	POPUP_000		=	0;
			static final int	POPUP_001		=	1;
			static final int	ONE_CLICK_002		=	2;
		}

		static class Group1
		{
			static final int	POPUP_000		=	3;
			static final int	POPUP_001		=	4;
			static final int	ONE_CLICK_002		=	5;
			static final int	ONE_CLICK_003		=	6;
		}

		static class Group2
		{
			static final int	POPUP_000		=	7;
			static final int	POPUP_001		=	8;
		}

	}


	
	public GL10 mGL = null; // OpenGL ��ü
	public Context MainContext;
	public Random MyRand = new Random();	
	public GameInfo gInfo; // ���� ȯ�� ������ Ŭ���� : MainActivity�� ����� ���� ���� �޴´�.
	public float TouchX, TouchY;
	public int CurLayer = 0;
    
	private Sprite SPR_bg;
	private GameObject OBJ_bg;
	private UITool MainUI;
	private Font font= new Font();

	public GameMain( Context context, GameInfo info )
	{
		MainContext = context;
		gInfo = info;
	}

	public void LoadGameData()
	{
//		SPR_bg= new Sprite();
//		SPR_bg.LoadSprite(mGL, MainContext, "salarycalc_main1.spr");
//		
//		OBJ_bg= new GameObject();
//		OBJ_bg.SetObject(SPR_bg, 0, 0, 0, 0, 0, 0);
		
		MainUI.LoadUI( mGL, MainContext, "page1.ui" ); // UI ������ �ε��Ѵ�.		
		/**
		 * ù��° ���ڴ� �׷� ��ȣ, �ι�°�� ���̾�̴�.
		 * ���̾�� ����ڰ� ���Ƿ� ������ �� �ִ�.
		 * ���� ���̾���� ������ ��ư���� ���ÿ� ��ġ�� �� �ִ�.
		 * AddGroup ���� UITool.UIList�� add �ǹǷ� ȣ���ϴ� ������� â�� ���������.
		 * ����Ʈ�並 ����ϰ� ���� ���, AddGroup �Ŀ� UITool.UIList�� add ��Ű�� �ȴ�. 
		 */
		MainUI.AddGroup( 0, 0 ); 
	}
	
	public void PushButton( boolean flag )
	{
		
	}
	
	public void DoGame()
	{
		this.Render();


		synchronized ( mGL )
		{
			font.BeginFont();
			
			MainUI.Draw( mGL, gInfo, font ); // ����� ��� UI�� ȭ�鿡 �׷��ش�.
			
			for ( int i = 0; i < MainUI.UIList.size(); i++ ) // ��� UI�� ��ư ��ġ ���¸� üũ�ϱ� ���� ����
			{
				/**
				 * ��ư�� index ���� UIButtonClass�� ���ǵ� �������� ���Ѵ�.
				 * �������� [Ŭ������].[�׷��].[��ưŸ��_������ȣ] ���·� �����Ǿ� �ִ�.
				 */
				if ( MainUI.UIList.get(i).index == UIPage1.Group0.ONE_CLICK_002 ) 
				{
					if ( MainUI.UIList.get(i).click == ButtonType.STATE_CLK_BUTTON )
					{
						MainUI.UIList.get(i).ResetButton();
						MainUI.DeleteLastGroup( gInfo );
						MainUI.AddGroup( 1, 1 );
					}
				}
			}
		}
		
	}
	
	protected void Render()
	{
		OBJ_bg.DrawSprite(gInfo);
	}
}
