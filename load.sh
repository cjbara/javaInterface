sqlite3 states.db << EOF
.read src/crt_roster.sql
.read src/crt_positions.sql
.read src/crt_states.sql
.read src/crt_zips.sql
.read src/crt_regions.sql
.read src/crt_streg.sql
.separator ,
.import data/ndroster.csv roster
.import data/positions.csv positions
.import data/states.csv states
.import data/allzips.csv uszips
.import data/regions.csv regions
.import data/streg.csv streg
EOF

