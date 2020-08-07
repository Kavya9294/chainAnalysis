import React from 'react';
import { Card,Statistic} from 'antd';
import { ArrowUpOutlined, ArrowDownOutlined } from '@ant-design/icons';

import './App.css';

class CurrencyCard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            Buycb:0.0,
            Sellcb:0.0,
            Buygemini:0.0,
            Sellgemini:0.0,
            bestSeller:"Gemini",
            bestSP:0.0,
            bestBuyer:"Gemini",
            bestBP:0.0}
          };

    componentDidMount() {
        const url = process.env.REACT_APP_API_URL;
        const req = new Request(url+"/getCurrency?currencyType="+this.props.type, {
            method: 'GET',
            cache: 'default'
          });
    fetch(req,
    {
        headers : { 
          'Content-Type': 'application/json',
          'Accept': 'application/json'
         }
  
      })
      .then((response) => {
          return response.clone().json()
        }
          )
      .then((data) => {
        this.setState({
            Buycb:data["Buycb"],
            Sellcb:data["Sellcb"],
            Buygemini:data["Buygemini"],
            Sellgemini:data["Sellgemini"],
            bestSeller:data["bestSeller"],
            bestSP:data["bestSP"],
            bestBuyer:data["bestBuyer"],
            bestBP:data["bestBP"]}
            );
        })
        
    };

    render() {
        const { Buycb, Sellcb,Buygemini,Sellgemini,bestSeller,bestSP,bestBuyer,bestBP} = this.state

        

            return (
            <div>
            <div className="insideCard">
                <div  className="subCard">
                    <Card title="Coinbase" id="titleClass" className="curveBorder">
                        <Statistic title="Buy Price" value={Buycb} />

                        <Statistic title="Sell Price" value={Sellcb} />

                    </Card>
                </div>
            
                <div  className="subCard" >
                <Card title="Gemini" id="titleClass" className="curveBorder">
                        <Statistic title="Buy Price" value={Buygemini} />
                        <Statistic title="Sell Price" value={Sellgemini} />
                </Card>
                </div>
            </div>
            <div className="insideCard">
            <Card title="Suggestions" id="titleClass" className="suggestionCard curveBorder">
                        <Statistic
                            title="Best Buying Price"
                            value={bestBP}
                            valueStyle={{ color: '#3f8600' }}
                            prefix={<ArrowDownOutlined />}
                            suffix={bestBuyer}
                        />

                        <Statistic
                            title="Best Selling Price"
                            value={bestSP}
                            valueStyle={{ color: '#3f8600' }}
                            prefix={<ArrowUpOutlined />}
                            suffix={bestSeller}
                        />


                </Card>
            </div>

            </div>
            );
            }
    }

export default CurrencyCard;
