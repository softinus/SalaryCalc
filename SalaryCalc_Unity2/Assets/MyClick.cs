using UnityEngine;
using System.Collections;



public class MyClick : MonoBehaviour {

	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update ()
	{
		//this.gameObject.rigidbody2D. Input.mousePosition.x

		// RaycastHit m_Hit; 
		// if ( Input.GetMouseButtonDown(0) == true ) //마우스를 눌르면
		// {
		// 	Debug.Log("X: "+Input.mousePosition.x+", Y: "+Input.mousePosition.y); 
		// 	Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition); //현재 마우스클릭한 위치
			
		// 	if ( Physics.Raycast(ray,out m_Hit,100)) // 피킹이 되면 m_Hit에 피킹된 오브젝트정보가 달려온다.
		// 	{
		// 		Debug.Log(m_Hit.transform.tag); 
		// 	}
		// }
	}




	public void MyClick_start()
	{
		Debug.Log("click start2!");
		Application.LoadLevel("main2");
	}

	public void MyClick_yes()
	{
		Debug.Log("click yes3!");
		Application.LoadLevel("main3");
	}

	public void MyClick_no()
	{
		Debug.Log("click no!");
		//Application.LoadLevel("main2");

		
	}

    void OnHover(bool isOver)
    {
        //Debug.Log("isOver: "+isOver);        
        bool bNObutton;
        if (this.gameObject.name.Equals("btn_no"))
            bNObutton = true;
        else
            bNObutton = false;


        if (isOver && bNObutton)
        {
            Transform currTrans = this.gameObject.transform;
            //currTrans.Translate(Vector3.up * 0.5f);

//            Random rnd = new Random();
            float fX= Random.Range(-1.1f, 1.1f);
            float fY = Random.Range(-0.6f, 0.6f);
            currTrans.position = new Vector3(fX, fY, 0);
        }
       
    }
}
