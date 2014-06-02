package gvm.gui

import javax.swing.*

application(title: 'gvm-gui',
        preferredSize: [640, 400],
        pack: true,
        //location: [50,50],
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                     imageIcon('/griffon-icon-32x32.png').image,
                     imageIcon('/griffon-icon-16x16.png').image]) {
    menuBar {
        menu('File') {
            menuItem('Quit', actionPerformed: controller.quitAction)
        }
        menu('Help') {
            menuItem('About', actionPerformed: controller.aboutAction)
        }
    }

    migLayout(layoutConstraints: 'fill', columnConstraints: '[40%][]')
    scrollPane(preferredSize: [320, 300]) {
        list(model: eventListModel(source: model.candidates), selectionMode: ListSelectionModel.SINGLE_SELECTION,
            mouseClicked: { e ->
                int selectionIndex = e.source.locationToIndex(e.point)
                model.selectedCandidate = (selectionIndex > -1) ? model.candidates[selectionIndex] : null
            },
            cellRenderer: new CandidateCellRenderer()
        )
    }
    scrollPane(preferredSize: [320, 300]) {
        list(model: eventListModel(source: model.versions), selectionMode: ListSelectionModel.SINGLE_SELECTION,
        mouseClicked: { e ->
            //int selectionIndex = e.source.locationToIndex(e.point)
            //model.selectedVersions = (selectionIndex > -1) ? model.versions[selectionIndex] : null
        })
    }
}
