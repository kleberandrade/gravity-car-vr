using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Sensores : MonoBehaviour {


    [SerializeField]
    private float m_MaxRange;
    private float m_Range;

    [SerializeField]
    private LayerMask m_LayerMask;
    [SerializeField]
    private Color m_NormalRayColor, m_CollisionRayColor;

    private void FixedUpdate()
    {
        RaycastHit hit;
     
        if (Physics.Raycast(transform.position, transform.TransformDirection(Vector3.forward), out hit, m_Range, m_LayerMask))
        {
            m_Range = hit.distance;
            Debug.DrawRay(transform.position, transform.TransformDirection(Vector3.forward) * m_Range, m_CollisionRayColor);
        }
        else
        {
            m_Range = m_MaxRange;
            Debug.DrawRay(transform.position, transform.TransformDirection(Vector3.forward) * m_Range, m_NormalRayColor);
        }


    }

}

