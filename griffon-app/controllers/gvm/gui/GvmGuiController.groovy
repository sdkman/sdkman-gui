package gvm.gui

import net.gvmtool.client.Candidate
import net.gvmtool.client.GvmClient

import java.awt.event.ActionEvent

class GvmGuiController {
    // these will be injected by Griffon
    GriffonModel model
    def view

    void mvcGroupInit(Map args) {
        model.addPropertyChangeListener('selectedCandidate', {evt -> refreshVersions()})
    }

    def refreshCandidates(ActionEvent evt = null) {
        List<Candidate> candidates = GvmClient.instance().candidates

        log.info("Refreshed Candidates")
        log.debug("${candidates*.name}")

        execInsideUIAsync {
            model.candidates.clear()
            model.candidates.addAll(candidates)
        }
    }

    def refreshVersions(ActionEvent evt = null) {
        execInsideUISync {
            model.versions.clear()
        }

        if (!model.selectedCandidate) {
            return
        }
        def selectedCandidate = model.selectedCandidate
        def versions = GvmClient.instance().getVersionsFor(selectedCandidate.name)

        log.info("Refreshed versions for candidate $selectedCandidate")
        log.debug("${versions*.name}")

        execInsideUIAsync {
            model.versions.addAll(versions)
        }
    }

	def quitAction = {ActionEvent evt = null ->
		println("Quit")
	}

	def aboutAction = {ActionEvent evt = null ->
		println("About")
	}
}
