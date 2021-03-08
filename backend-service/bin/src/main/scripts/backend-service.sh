echo ${M2_HOME}
classpth="${M2_HOME}\\edu\\episen\\si\\ing1\\pds\\backend-service\\1.0-SNAPSHOT\\backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar"
exec java -cp ${classpth} edu.episen.si.ing1.pds.backend.server.BackendService $*