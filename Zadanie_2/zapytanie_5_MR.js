db.people.mapReduce(
	function() {
		this.credit.forEach(creditCard => {
			emit(creditCard.currency, creditCard.balance);
		});
	},
	
	function (key, values) {
		const suma = Array.sum(values);
		const średnia = suma / values.length;

		return {średnia, suma};
	},
	
	{
		query: {
			sex: 'Female',
			nationality: 'Poland'
		},
		out: 'outputCollection_5'
	}
);

printjson(db.outputCollection_5.find().toArray());