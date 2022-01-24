printjson(
db.people.insert({
	sex: 'Male',
	first_name: 'Artur',
	last_name: 'Lepczyński',
	job: 'Student',
	email: 's14922@pjwstk.edu.pl',
	location: {
		city: 'Warsaw',
		address: {streetname: 'Balonowa', streetnumber: '10'}
	},
	description: "Normal person",
	height: 182,
	weight: 80,
	birth_date: '1995-02-17T22:07:00Z',
	nationality: 'Poland',
	credit: [
		{
			  type: 'visa',
			  number: '1111222233334444',
			  currency: 'PLN',
			  balance: '1000'
		}
	]
}));