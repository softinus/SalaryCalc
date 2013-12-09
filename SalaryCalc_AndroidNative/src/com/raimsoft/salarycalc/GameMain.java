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


	
	public GL10 mGL = null; // OpenGL 객체
	public Context MainContext;
	public Random MyRand = new Random();	
	public GameInfo gInfo; // 게임 환경 설정용 클래스 : MainActivity에 선언된 것을 전달 받는다.
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
		
		MainUI.LoadUI( mGL, MainContext, "page1.ui" ); // UI 파일을 로드한다.		
		/**
		 * 첫번째 인자는 그룹 번호, 두번째는 레이어값이다.
		 * 레이어값은 사용자가 임의로 지정할 수 있다.
		 * 같은 레이어값으로 지정된 버튼들은 동시에 터치될 수 있다.
		 * AddGroup 사용시 UITool.UIList에 add 되므로 호출하는 순서대로 창이 만들어진다.
		 * 리스트뷰를 사용하고 싶은 경우, AddGroup 후에 UITool.UIList에 add 시키면 된다. 
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
			
			MainUI.Draw( mGL, gInfo, font ); // 등록한 모든 UI를 화면에 그려준다.
			
			for ( int i = 0; i < MainUI.UIList.size(); i++ ) // 모든 UI의 버튼 터치 상태를 체크하기 위한 루프
			{
				/**
				 * 버튼의 index 값과 UIButtonClass에 정의된 고유값을 비교한다.
				 * 고유값은 [클래스명].[그룹명].[버튼타입_고유번호] 형태로 구성되어 있다.
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
