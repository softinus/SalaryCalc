using UnityEngine;
using System.Collections;


public class MainScript : MonoBehaviour {

	// Use this for initialization
	void Start ()
	{
	
	}



	void OnGUI()
	{
		//if (!btnTexture)
		//{
			//Debug.LogError("Please assign a texture on the inspector");
			//return;
		//}
		if (GUI.Button(new Rect(300, 380, 120, 50), "Start!"))
			Debug.Log("Clicked the button with an image");
		
		//if (GUI.Button(new Rect(10, 70, 50, 30), "Click"))
			//Debug.Log("Clicked the button with text");
		
	}
	
	// Update is called once per frame
	void Update () {
	
	}
}
