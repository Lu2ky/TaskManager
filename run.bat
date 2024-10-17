set PATH_TO_FX="C:\Users\bohor\Documents\lib"
java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -Djava.library.path="%PATH_TO_FX%\bin" -jar TaskManager.jar
