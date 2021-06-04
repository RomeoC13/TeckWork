echo ${M2_REPO}
classpth="${M2_REPO}\\edu\\episen\\si\\ing1\\pds\\backend-service\\1.0-SNAPSHOT\\backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar"
#exec java -cp ${classpth} edu.episen.si.ing1.pds.backend.server.BackendService $*
exec java -cp ${classpth} edu.episen.si.ing1.pds.backend.server.release2.Server $*
#exec java -cp ${classpth} edu.episen.si.ing1.pds.backend.server.DBConnection $*
