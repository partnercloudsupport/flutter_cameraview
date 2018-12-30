package io.github.hramaroson.fluttercamerakit.core;

import android.hardware.Camera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class CameraControllerManager1 extends CameraControllerManager {
    @Override
    public int getNumberOfCameras() {
        return Camera.getNumberOfCameras();
    }

    @Override
    public List<Map<String, Object>> getCameraDescriptionList() {
        List<Map<String,Object>> cameras = new ArrayList<>();

        int camera_count = Camera.getNumberOfCameras();
        for(int Id=0; Id<camera_count ; Id++){
            HashMap<String, Object> details = new HashMap<>();
            details.put("name", Id);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(Id, cameraInfo);
            switch (cameraInfo.facing){
                case Camera.CameraInfo.CAMERA_FACING_FRONT:
                    details.put("lensFacing", "front");
                    break;
                case Camera.CameraInfo.CAMERA_FACING_BACK:
                    details.put("lensFacing", "back");
                    break;
            }
            cameras.add(details);
        }
        return null;
    }
}