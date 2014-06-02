package gvm.gui

application(title: 'gvm-gui',
  preferredSize: [320, 240],
  pack: true,
  //location: [50,50],
  locationByPlatform: true,
  iconImage:   imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill', columnConstraints: '[40%][]')
    scrollPane(preferredSize: [320, 160]) {
        table {
            tableFormat = defaultTableFormat(columnNames: ['Name'])
            eventTableModel(source: model.candidates, format: tableFormat)
        }
    }
}
