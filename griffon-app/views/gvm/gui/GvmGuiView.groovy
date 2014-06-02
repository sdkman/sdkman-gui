package gvm.gui

application(title: 'gvm-gui',
        preferredSize: [640, 400],
        pack: true,
        //location: [50,50],
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                     imageIcon('/griffon-icon-32x32.png').image,
                     imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill', columnConstraints: '[40%][]')
    scrollPane(preferredSize: [320, 300]) {
        table {
            tableFormat = defaultAdvancedTableFormat(
                    columns: [
                            [
                                    name : 'name',
                                    class: String
                            ]
                    ]
            )
            //columnModel = columnModel {
            //    column("name", modelIndex: 0, headerValue: "Candidates", width: [50, 100])
            //}
            eventTableModel(source: model.candidates, format: tableFormat)
        }
    }
    scrollPane(preferredSize: [320, 300]) {
        table {
            tableFormat = defaultTableFormat(columnNames: ['Version'])
            eventTableModel(source: model.versions, format: tableFormat)
        }
    }
}
