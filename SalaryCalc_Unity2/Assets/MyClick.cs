using UnityEngine;
using System.Collections;

public class MyClick : MonoBehaviour {

	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	public void MyClick2()
	{
		Debug.Log("click start!");
		Application.LoadLevel("main2");
	}
}
