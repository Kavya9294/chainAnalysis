import React from 'react';
import './App.css';
import CurrencyCard from './CurrencyCard';
import {Card} from 'antd';

function App() {
  return (
    <div className="App">
      <header className="App-header" >
      <Card title="BTC and ETH Exchange Rate Analysis" bodyStyle={{paddingTop: "0px"}}>
      <Card title="Bitcoin(BTC)" id="titleClass" bordered={false} bodyStyle={{backgroundColor: "#eee", padding:"5px", borderRadius:"10px"}} >
        <div className="exchange">
          <div className="currencyType">
            <CurrencyCard type="BTC" ></CurrencyCard>
          </div>
      </div>
      </Card>
      <Card title="Ethereum(ETH)" id="titleClass" bordered={false} bodyStyle={{backgroundColor: "#eee", padding:"5px",borderRadius:"10px"}}>
        <div className="exchange">
          <div className="currencyType">
            <CurrencyCard type="ETH" ></CurrencyCard>
          </div>
      </div>
      </Card>
      </Card>
      </header>
    </div>
  );
}

export default App;
