<?php
require_once implode('/', array(__DIR__, 'lib', 'begin0.php')); 
require_once implode('/', array(__DIR__, 'lib', 'icon.php'));
require_once implode('/', array(__DIR__, 'lib', 'point_light.php'));

class Persistence {
    /**
     * request handler insntace
     */
    static $instance = NULL;

    /**
     * constructor
     */
    function __construct() {
    }

    /**
     * start recieve request
     */
    function start() {
        if (isset($_REQUEST['icon'])) {
            $this->icon();
        }
        if (isset($_REQUEST['point-light'])) {
            $this->point_light();
        }
    } 


    /**
     * handle icon request
     */ 
    function icon()
    {
        Session::$instance->start();
        $id = Session::$instance->get_id();
        if ($id) {
            $command = $_REQUEST['icon'];
            $resp = NULL;
            if ($command == 'write') {
                $res = FALSE;
                if (isset($_REQUEST['data'])) {
                    $iconData = json_decode($_REQUEST['data'], TRUE);
                    $res = Icon::$instance->write($id, $iconData);
                    Session::$instance->update_session();
                }
                $resp = array('status' => $res);
            } else if ($command == 'read') {
                $iconData = Icon::$instance->read($id);
                if ($iconData) {
                    $resp = array('status' => TRUE,
                        'data' => $iconData);
                } else {
                    $resp = array('status' => FALSE);
                }
            } else {
                $resp = array('status' => FALSE);
            }
            $this->response_as_json($id, $resp);
        }
    }

    /**
     * handle point-light request
     */ 
    function point_light()
    {

        Session::$instance->start();
        $id = Session::$instance->get_id();
        if ($id) {
            $command = $_REQUEST['point-light'];
            $resp = NULL;
            if ($command == 'write') {
                $res = FALSE;
                if (isset($_REQUEST['data'])) {
                    $pointLightData = json_decode($_REQUEST['data'], TRUE);
                    $res = PointLight::$instance->write($id, $pointLightData);
                    Session::$instance->update_session();
                }
                $resp = array('status' => $res);
            } else if ($command == 'read') {
                $iconData = PointLight::$instance->read($id);
                if ($iconData) {
                    $resp = array('status' => TRUE,
                        'data' => $iconData);
                } else {
                    $resp = array('status' => FALSE);
                }
            } else {
                $resp = array('status' => FALSE);
            }
            $this->response_as_json($id, $resp);
        }
    }



    /**
     * echo data as json back to client.
     */
    function response_as_json($id, $response) {
        Session::$instance->setcookie($id);
        echo json_encode($response);
    }
}

Persistence::$instance = new Persistence();
Persistence::$instance->start();
// vi: se ts=4 sw=4 et:
