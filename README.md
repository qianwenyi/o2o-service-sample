# o2o-service-sample
the sample of o2o service

<p>========= Model ==========</p>
The ReproduceBorrowedDocument.xml file shows the UPPAAL model of the Reproduce Borrowed Document sample, which is generated by the method PathPlanner.src.uppaal.UppaalPlan.generateUppaalFile in the Implementation folder.
The uppaal-cora-060910 folder contains the UPPAAL tool used in the paper.

<p>========= Data ===========</p>
The Data folder contains the detailed experimental data of the process to complete the Reproduce Borrowed Document service with 5-agent-social-collaboration. Each file shows one scenario, for example, 5A0g0d1200.txt file shows the details with 5 agents in group 0 while the user's start location is 0, and the time constraint is 1200 time units. All the data can be generated with the source code in the Implementation folder.

<p>===== Implementation =====</p>
The main algorithm is implemented by the PathPlanner.src.algorithm.MCMCSearch.search method. The files in PathPlanner.src.Main package shows the example of Reproduce Borrowed Document example. Main methond in file Main4a1, Main4a2, Main4a3, Main4a4, and Main4a5 will compute the time and cost spent of the service with 1-, 2-, 3-, 4-, and 5-agent-social-collaboration. Main method in file Main4S will compute the time and cost spent for the conventional approach. Main method in file OAMain will compute the time and cost spent for the offline-aware approach. Till now, all the dataset is hardcoded in the source code.
