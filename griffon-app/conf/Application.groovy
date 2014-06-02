application {
    title = 'GvmGui'
    startupGroups = ['gvm-gui']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "gvm-gui"
    'gvm-gui' {
        model      = 'gvm.gui.GvmGuiModel'
        view       = 'gvm.gui.GvmGuiView'
        controller = 'gvm.gui.GvmGuiController'
    }

}
