package gvm.gui

import net.gvmtool.client.Candidate
import net.gvmtool.client.GvmClient

import java.awt.event.ActionEvent

class GvmGuiController {
    // these will be injected by Griffon
    GriffonModel model
    def view

    def refreshCandidates(ActionEvent evt = null) {
        List<Candidate> candidates = GvmClient.instance().candidates

        log.info("Refreshed Candidates")
        log.debug("${candidates*.name}")

        execInsideUIAsync {
            model.candidates.clear()
            model.candidates.addAll(candidates)
        }
    }
}
