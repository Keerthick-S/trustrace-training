const express = require('express')
const fs = require('fs');
const body = require('body-parser');
const _ = require('lodash');
const { MAX_LIMIT } = require('./constant-var');
const app = express()
const cors = require('cors');
const { name } = require('ejs');
app.use(cors());

app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});         

app.use(body.json());

app.get('/page1', (req, res) => {
  res.send('Page One')
  return false;
})

app.get('/page2', (req, res) => {
  res.send('Page Two')
  return false;
})

app.get('/page3', (req, res) => {
  res.send('Page Three')
  return false;
})

app.get('/json', (req, res) => {
  res.json({ myName: 'Keerthick' })
  return false;
})

app.get('/html', (req, res) => {
  res.sendFile('/index.html', { root: __dirname })
  return false;
})

app.get('/xml', (req, res) => {
  res.sendFile('/demoXML.xml', { root: __dirname })
  return false;
})

app.get('/image', (req, res) => {
  res.sendFile('casual-pic.JPG', { root: __dirname })
  return false;
})

app.get('/gif', (req, res) => {
  res.sendFile('nature.gif', { root: __dirname })
  return false;
})

app.get('/video', (req, res) => {
  res.sendFile('demo-video.MP4', { root: __dirname })
  return false;
})

// const data = fs.readFileSync('details.json');
// const getDetails = JSON.parse(data);

app.get('/employees', (req, res) => {
  res.json(parseJson());
  return false;
})

function parseJson() {
  const datas = fs.readFileSync('details.json');
  const getDetails = JSON.parse(datas);
  return getDetails;
}

app.get('/employees', (req, res) => {

  const getDetails = parseJson();
  let page = parseInt(req.query.page);
  let limit = parseInt(req.query.limit);

  if (limit > MAX_LIMIT) {
    limit = MAX_LIMIT;
  }

  if (!page) {
    page = 1;
  }

  if (!limit) {
    limit = 10;
  }

  const start = (page - 1) * limit;
  const end = page * limit;

  const result = getDetails.slice(start, end);
  const data = {
    details: result,
    count: getDetails.length,
  };
  res.json(data);
  return false;
})

app.post('/create', (req, res) => {
  const employees = parseJson();
  const phoneNo = _.find(employees, { phone_number: req.body.phone_number });
  
  const ids = employees.map(object => {
    return object.user_id;
    })

  if (phoneNo) {
    res.status(400).json({ error: 'This Phone Number is already taken' });
    return false;
  }

  const input = req.body;
  const maxId = parseInt(_.max(ids)) + 1;
  
  input.user_id = maxId;
  employees.push(input);
  fs.writeFileSync('details.json', JSON.stringify(employees));
  res.json({ message: 'User Detail is successfully added' });
  return false;
})

app.put('/:user_id/edit', (req, res) => {

  const employees = parseJson();
  const employee = _.find(employees, { user_id: req.params['user_id']});
  const index = _.findIndex(employees, { 'user_id': req.params['user_id'] });
  let flag = false;
  
  if (index === -1) {
    res.status(400).json({ message: 'Invalid User ID' });
    return false;
  }

  const employeesTemp = employees.map((employeeTemp, indexTemp) => {

    if(index !== indexTemp) {
      return employeeTemp;
    }
  })

  if (req.body.name) {
    employee.name = req.body.name;
    flag = true;
  }

  if(req.body.phone_number) {
    const employeeNumber = _.find(employeesTemp, { 'phone_number': req.body.phone_number });
    if(employeeNumber) {
      res.status(400).json({ message: 'This Phone Number is already taken'});
      return false;
    }
    employees[index].phone_number = req.body.phone_number;
    flag = true;
  }

  if (req.body.email) {
    const employeeEmail = _.find(employeesTemp, { email: req.body.email });

    if(employeeEmail) {
      res.json({ message: 'This Email is already taken'});
      return false;
    }
    employees[index].email = req.body.email;
    flag = true;
  }

  if(flag) {
    fs.writeFileSync('details.json', JSON.stringify(employees));
    res.json({message: 'Updated Successfully'});
    return false;
  }

})

app.delete('/delete/:user_id',(req, res) => {

  const employees = parseJson();
  const employee = _.find(employees, { user_id: req.params['user_id']});

  if(!employee) {
    res.json({message: 'Invalid User ID'});
    return false;
  }

  _.remove(employees, {user_id: employee.user_id});
  fs.writeFileSync('details.json', JSON.stringify(employees));
  res.json({message: 'Deleted Successfully'});
  return false;
})

app.get('/getOne}', (req, res) => {
  const employees = parseJson();
  const employee = _.find(employees, { user_id: parseInt(req.query.user_id) });

  if(!employee) {
    res.json({message: 'Invalid User ID'});
    return false;
  }

  res.json(employee);
  return false;

})

app.use((req, res) => {
  res.status(404)
  res.send('Page Not Found')
  return false;
})

app.listen(8000, () => {
  console.log('8000');
})