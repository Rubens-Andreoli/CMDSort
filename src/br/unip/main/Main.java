package br.unip.main;

import br.unip.controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.startView();
        controller.controlView();

    }

}
