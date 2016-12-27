import sys
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5.uic.properties import QtCore

from src.gui.main import Ui_MainWindow

app = QApplication(sys.argv)
window = QMainWindow()
ui = Ui_MainWindow()
ui.setupUi(window)

window.show()


def test():
    print("hello")

def mousePressEvent(self, event):
    super(self).mousePressEvent(event)
    print(event)

ui.PlayPause.clicked.connect(test)

ui.ListArtists.addItem("Hallo")

ui.ListArtists.addAction(ui.actionLeftClick)
ui.ListArtists.addAction(ui.actionRightClick)

sys.exit(app.exec_())