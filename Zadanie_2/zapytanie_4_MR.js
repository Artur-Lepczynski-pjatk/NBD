db.people.mapReduce(
	function() {
		emit(this.nationality, {weight: this.weight, height: this.height});
	},
  
	function (key, values) {
		let sumaBMI = 0;
		let minimalneBMI = Infinity;
		let maksymalneBMI = 0;
		

		values.forEach(person => {
			const heightMeters = person.height / 100;
			const BMI = person.weight / (heightMeters * heightMeters);
			
			sumaBMI += BMI;
			if (BMI > maksymalneBMI) maksymalneBMI = BMI;
			if (BMI < minimalneBMI) minimalneBMI = BMI;
		});

		return {srednieBMI: sumaBMI / values.length, minimalneBMI, maksymalneBMI};
	},
	{out: 'outputCollection_4'}
);

printjson(db.outputCollection_4.find().toArray());