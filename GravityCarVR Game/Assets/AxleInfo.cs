using UnityEngine;

[System.Serializable]
public class AxleInfo
{
    [Header("Meshes")]
    public GameObject m_LeftWheelMesh;
    public GameObject m_RightWheelMesh;

    [Header("Colliders")]
    public WheelCollider m_LeftWheelCollider;
    public WheelCollider m_RightWheelCollider;

    [Header("Constraints")]
    public bool m_UseMotor;
    public bool m_UseSteering;
}
