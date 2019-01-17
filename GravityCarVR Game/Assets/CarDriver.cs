using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CarDriver : MonoBehaviour
{
    public List<AxleInfo> m_AxleInfos;
    public float m_MaxMotorTorque;
    public float m_MaxSteeringAngle;
    public float m_BrakeTorque;
    public float m_DecelerationForce;
    public float m_RoadTime;

    private void Brake(AxleInfo axleInfo, bool braking)
    {
        if (braking)
        {
            axleInfo.m_LeftWheelCollider.brakeTorque = m_BrakeTorque;
            axleInfo.m_RightWheelCollider.brakeTorque = m_BrakeTorque;
        }
        else
        {
            axleInfo.m_LeftWheelCollider.brakeTorque = 0;
            axleInfo.m_RightWheelCollider.brakeTorque = 0;
        }
    }

    private void Deceleration(AxleInfo axleInfo)
    {
        axleInfo.m_LeftWheelCollider.brakeTorque = m_DecelerationForce;
        axleInfo.m_RightWheelCollider.brakeTorque = m_DecelerationForce;
    }

    private void Steering(AxleInfo axleInfo, float steering)
    {
        axleInfo.m_LeftWheelCollider.steerAngle = steering;
        axleInfo.m_RightWheelCollider.steerAngle = steering;
    }

    private void Aceleration(AxleInfo axleInfo, float motor)
    {
            axleInfo.m_LeftWheelCollider.motorTorque = motor;
            axleInfo.m_RightWheelCollider.motorTorque = motor;
    }

    private void ApplyPositionVisuals(AxleInfo axleInfo)
    {
        Vector3 position;
        Quaternion rotation;

        axleInfo.m_LeftWheelCollider.GetWorldPose(out position, out rotation);
        if (axleInfo.m_LeftWheelMesh)
        {
            axleInfo.m_LeftWheelMesh.transform.position = position;
            axleInfo.m_LeftWheelMesh.transform.rotation = rotation;
        }

        axleInfo.m_RightWheelCollider.GetWorldPose(out position, out rotation);
        if (axleInfo.m_RightWheelMesh)
        {
            axleInfo.m_RightWheelMesh.transform.position = position;
            axleInfo.m_RightWheelMesh.transform.rotation = rotation;
        }
    }

    private float deltaTime()
    {
        return m_RoadTime += 1.0f;
    }

    private void FixedUpdate()
    {
        float motor = 9.8f * 500 * deltaTime();
        float steering = Input.GetAxis("Horizontal") * m_MaxSteeringAngle *2.0f;
        bool braking = Input.GetButton("Jump");

        foreach (AxleInfo axleInfo in m_AxleInfos)
        {
            Brake(axleInfo, braking);

            if (axleInfo.m_UseSteering)
                Steering(axleInfo, steering);

            if (axleInfo.m_UseMotor)
                Aceleration(axleInfo, motor);

            ApplyPositionVisuals(axleInfo);
        }
    }
}
