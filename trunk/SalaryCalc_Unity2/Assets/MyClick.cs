using UnityEngine;
using System.Collections;

public class MyClick : MonoBehaviour {

	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	public void MyClick_start()
	{
		Debug.Log("click start!");
		Application.LoadLevel("main2");
	}

	public void MyClick_yes()
	{
		Debug.Log("click yes!");
		Application.LoadLevel("main2");
	}

	public void MyClick_no()
	{
		Debug.Log("click no!");
		//Application.LoadLevel("main2");
	}
}
